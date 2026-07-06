КРИСТАЛЛ РЕГЕНЕРАЦИИ
Minecraft 1.21.1 + NeoForge 21.1.235 + Java 21

ЧТО ДЕЛАЕТ МОД
- Добавляет блок «Кристалл регенерации».
- Блок находится во вкладке «Функциональные блоки» творческого режима.
- При нажатии правой кнопкой мыши кристалл выдаёт регенерацию на 10 секунд
  всем живым игрокам в радиусе 5 блоков.
- Кристалл светится с уровнем света 10.
- Его можно добыть железной киркой или инструментом лучше.
- Рецепт: аметистовые осколки, алмазы и Кристалл Края.

КАК СОБРАТЬ НА WINDOWS
1. Установите JDK 21.
2. Распакуйте папку в обычное место без кириллицы в длинном пути, например C:\MinecraftMods\RegenerationCrystalMod.
3. Запустите BUILD_MOD.bat.
4. При первом запуске Gradle и зависимости NeoForge скачаются из интернета.
5. Готовый файл появится в папке build\libs.

КАК ЗАПУСТИТЬ В INTELLIJ IDEA
1. Откройте эту папку как проект.
2. Выберите JDK 21.
3. Дождитесь импорта Gradle.
4. В панели Gradle запустите runs -> runClient либо задачу runClient.

КАК УСТАНОВИТЬ ГОТОВЫЙ JAR
1. Установите NeoForge для Minecraft 1.21.1.
2. Поместите JAR из build\libs в папку .minecraft\mods.
3. Запустите профиль NeoForge 1.21.1.

ГДЕ ЧТО ЛЕЖИТ
- Java-код: src\main\java\ru\creativika\regenerationcrystal
- Модель: src\main\resources\assets\regeneration_crystal\models\block
- Текстура: src\main\resources\assets\regeneration_crystal\textures\block
- Исходник Blockbench: blockbench_source\regeneration_crystal.bbmodel

ВАЖНО
Папка собрана под Minecraft 1.21.1. Для другой версии Minecraft потребуется
поменять версии NeoForge и, возможно, отдельные участки кода и ресурсов.
