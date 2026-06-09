from SistemaEmpleados import Empleado
class Administrativo(Empleado):
    def __init__(self, nombre, salario, departamento):
        super().__init__(nombre, salario)
        self.__departamento = departamento
    @property
    def departamento(self):
        return self.__departamento
    @departamento.setter
    def departamento(self, nuevo_departamento):
        if nuevo_departamento != "":
            self.__departamento = nuevo_departamento
        else:
            print("Debe especificar un departamento")
    def mostrar_info(self):
        super().mostrar_info()
        print("Departamento:", self.__departamento)
