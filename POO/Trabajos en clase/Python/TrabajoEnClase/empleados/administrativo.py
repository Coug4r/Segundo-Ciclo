from empleados.empleado import Empleado

class Administrativo(Empleado):
    def __init__(self, nombre, salario, departamento):
        super().__init__(nombre, salario)
        self.departamento = departamento

    @property
    def departamento(self):
        return self.__departamento

    @departamento.setter
    def departamento(self, nuevo_departamento):
        if isinstance(nuevo_departamento, str) and nuevo_departamento.strip():
            self.__departamento = nuevo_departamento.strip()
        else:
            raise ValueError("El departamento debe ser un texto no vacío.")

    def mostrar_info(self):
        return f"Administrativo: {self.nombre}, Salario: {self.salario}, Departamento: {self.departamento}"
