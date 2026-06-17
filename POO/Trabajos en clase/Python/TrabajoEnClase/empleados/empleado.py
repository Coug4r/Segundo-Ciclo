class Empleado:
    def __init__(self, nombre, salario):
        self.nombre = nombre
        self.salario = salario

    @property
    def nombre(self):
        return self.__nombre

    @nombre.setter
    def nombre(self, nuevo_nombre):
        if isinstance(nuevo_nombre, str) and nuevo_nombre.strip():
            self.__nombre = nuevo_nombre.strip()
        else:
            raise ValueError("El nombre debe ser un texto no vacío.")

    @property
    def salario(self):
        return self.__salario

    @salario.setter
    def salario(self, nuevo_salario):
        if isinstance(nuevo_salario, (int, float)) and nuevo_salario > 0:
            self.__salario = nuevo_salario
        else:
            raise ValueError("El salario debe ser un número positivo.")

    def mostrar_info(self):
        return f"Empleado: {self.nombre}, Salario: {self.salario}"
