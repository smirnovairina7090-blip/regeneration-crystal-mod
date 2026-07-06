$ErrorActionPreference = "Stop"
$projectDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$gradleVersion = "9.2.1"
$toolsDir = Join-Path $projectDir ".local-tools"
$gradleDir = Join-Path $toolsDir "gradle-$gradleVersion"
$zipPath = Join-Path $toolsDir "gradle-$gradleVersion-bin.zip"

Write-Host "Проверка Java..." -ForegroundColor Cyan
& java -version
if ($LASTEXITCODE -ne 0) {
    throw "Java не найдена. Установите JDK 21 и повторите запуск."
}

if (!(Test-Path $gradleDir)) {
    New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null
    $url = "https://services.gradle.org/distributions/gradle-$gradleVersion-bin.zip"
    Write-Host "Скачивание Gradle $gradleVersion..." -ForegroundColor Cyan
    Invoke-WebRequest -Uri $url -OutFile $zipPath
    Write-Host "Распаковка Gradle..." -ForegroundColor Cyan
    Expand-Archive -Path $zipPath -DestinationPath $toolsDir -Force
}

$gradle = Join-Path $gradleDir "bin\gradle.bat"
Push-Location $projectDir
try {
    & $gradle build
    if ($LASTEXITCODE -ne 0) {
        throw "Сборка завершилась с ошибкой."
    }
    Write-Host "Готово. JAR находится в build\libs\" -ForegroundColor Green
}
finally {
    Pop-Location
}
