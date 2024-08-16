## Принципы SOLID

### Задача: Доработать упражнение, начатое на занятии

1\. Спроектировать абстрактный класс Car у которого должны быть свойства:
марка, модель, цвет, тип кузова, число колёс, тип топлива, тип коробки
передач, объём двигателя; методы: движение, обслуживание, переключение
передач, включение фар, включение дворников.

2\. Создать конкретный автомобиль путём наследования класса Car.

3\. Расширить абстрактный класс Car, добавить метод: подметать улицу. Создать
конкретный автомобиль путём наследования класса Car. Провести проверку
принципа SRP.

4\. Расширить абстрактный класс Car, добавить метод: включение противотуманных
фар, перевозка груза. Провести проверку принципа OCP.

5\.Создать конкретный автомобиль путём наследования класса Car, определить
число колёс = 3. Провести проверку принципа LSP.

6\. Создать конкретный автомобиль путём наследования класса Car, определить
метод «движение» - «полёт». Провести проверку принципа LSP.

7\. Создать интерфейс «Заправочная станция», создать метод: заправка топливом.

8\. Имплементировать метод интерфейса «Заправочная станция» в конкретный класс
Car.

9\. Добавить в интерфейс «Заправочная станция» методы: протирка лобового
стекла, протирка фар, протирка зеркал.

10\. Имплементировать все методы интерфейса «Заправочная станция» в конкретный
класс Car. Провести проверку принципа ISP. Создать дополнительный/е
интерфейсы и имплементировать их в конкретный класс Car. Провести проверку
принципа ISP.

11\. Создать путём наследования класса Car два автомобиля: с бензиновым и
дизельным двигателями, имплементировать метод «Заправка топливом» интерфейса
«Заправочная станция». Реализовать заправку каждого автомобиля подходящим
топливом. Провести проверку принципа DIP.

**UML-диаграма классов, иллюстрирующая применение принципа инверсии зависимостей**

![Снимок экрана от 2024-08-16 22-24-02](https://github.com/user-attachments/assets/456d8020-0ff0-41ab-9db9-ba5575d0df08)

*Тест*

![Снимок экрана от 2024-08-16 21-49-26](https://github.com/user-attachments/assets/865215c2-e994-4667-b528-08666cec2167)
