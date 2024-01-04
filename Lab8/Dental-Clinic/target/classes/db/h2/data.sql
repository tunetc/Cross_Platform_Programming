INSERT INTO Clinic (name, location) VALUES
    ('Рівненська центральна міська лікарня', 'м.Рівне, вул.Миколи Карнаухова, буд.27А'),
    ('Рівненська міська лікарня №2', 'м.Рівне, вул.Олександра Олеся, буд.13');

INSERT INTO Doctor (name, specialization, clinic_id) VALUES
    ('Іваненко Сергій Миколайович', 'Кардіолог', 1),
    ('Голобородько Іван Ничипорович', 'Педіатр', 2),
    ('Карпухіна Вікторія Олегівна', 'Ортопедичний Хірург', 1),
    ('Сидорова Марія Іванівна', 'Дерматолог', 2);


INSERT INTO Patient (name, age, sex, doctor_id) VALUES
    ('Бажан Максим Вікторович', 30, 'M', 1),
    ('Бандура Жанна Генадіївна', 25, 'F', 2),
    ('Буднік Василь Остапович', 40, 'M', 3),
    ('Бернадська Наталія Леонідівна', 5, 'F', 2),
    ('Макухін Валерій Петрович', 60, 'M', 4);
