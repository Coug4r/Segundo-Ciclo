from empleados.empleado import Empleado

class Docente(Empleado):
    def __init__(self, nombre, salario, materia):
        super().__init__(nombre, salario)
        self.materia = materia

    @property
    def materia(self):
        return self.__materia

    @materia.setter
    def materia(self, nueva_materia):
        if isinstance(nueva_materia, str) and nueva_materia.strip():
            self.__materia = nueva_materia.strip()
        else:
            raise ValueError("La materia debe ser un texto no vacío.")

    def mostrar_info(self):
        return f"Docente: {self.nombre}, Salario: {self.salario}, Materia: {self.materia}"
