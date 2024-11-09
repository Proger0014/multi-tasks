# multi-tasks

Тестовое задание, которое включает в себя 3 проекта

## Задание 1. Dependency Resolver

### Описание

Задание, которое заключается в том, чтобы разрешить зависимости в тестовых файлах, либо указать причину невозможности этого

К примеру, есть структура файлов:

- ``Folder1/Text1.txt``
- ``Folder2/Text2.txt``
- ``Folder3/Text3.txt``

В Folder1 данное содержание:

```
Some text

require Folder1/Text2.txt
```

В Folder2:

```
Some text

require Folder3/Text3.txt

Some text
```

в Folder3:

```
Some text

require Folder2/Text2.txt
```

При попытке разрешить данную зависимость, должно произойти исключение, потому что происходит попытка разрешить циклическую зависимость:

```bash
java -jar example-dependency-resolver.jar -out final-text.txt

Ошибка разрешения зависимостей: Циклическая зависимость:

- Folder2/Text2.txt <-> Folder3/Text3.txt
```