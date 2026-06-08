class Empleado:
    def __init__(self, nombre, salario):
        self.nombre = nombre
        self.salario = salario

    def mostrar_info(self):
        print("Nombre:", self.nombre)
        print("Salario:", self.salario)

class Docente(Empleado):
    def __init__(self, nombre, salario, materia):
        super().__init__(nombre, salario)
        self.materia = materia

    def mostrar_info(self):
        super().mostrar_info()
        print("Materia:", self.materia)

class Administrativo(Empleado):
    def __init__(self, nombre, salario, departamento):
        super().__init__(nombre, salario)
        self.departamento = departamento

    def mostrar_info(self):
        super().mostrar_info()
        print("Departamento:", self.departamento)

# Objetos
docente1 = Docente("Carlos Pérez", 1200, "Programación")
administrativo1 = Administrativo("Ana Gómez", 950, "Talento Humano")

print("DOCENTE")
docente1.mostrar_info()
print("\nADMINISTRATIVO")
administrativo1.mostrar_info()
class Empleado:
    def __init__(self, nombre, salario):
        self.nombre = nombre
        self.salario = salario

    def mostrar_info(self):
        print("Nombre:", self.nombre)
        print("Salario:", self.salario)

class Docente(Empleado):
    def __init__(self, nombre, salario, materia):
        super().__init__(nombre, salario)
        self.materia = materia

    def mostrar_info(self):
        super().mostrar_info()
        print("Materia:", self.materia)

class Administrativo(Empleado):
    def __init__(self, nombre, salario, departamento):
        super().__init__(nombre, salario)
        self.departamento = departamento

    def mostrar_info(self):
        super().mostrar_info()
        print("Departamento:", self.departamento)

# Objetos
docente1 = Docente("Carlos Pérez", 1200, "Programación")
administrativo1 = Administrativo("Ana Gómez", 950, "Talento Humano")

print("DOCENTE")
docente1.mostrar_info()
print("\nADMINISTRATIVO")
administrativo1.mostrar_info()
