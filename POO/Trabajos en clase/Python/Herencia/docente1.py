from SistemaEmpleados import Empleado
class Docente(Empleado):
    def __init__(self, nombre, salario, materia):
        super().__init__(nombre, salario)
        self.__materia = materia
    @property
    def materia(self):
        return self.__materia
    
    @materia.setter
    def materia(self,nueva_materia):
        if nueva_materia != "":
            self.__materia = nueva_materia
        else:
            print("Debe especificar una nueva Materia")
    
    def mostrar_info(self):
        super().mostrar_info()
        print("Materia:", self.__materia)
