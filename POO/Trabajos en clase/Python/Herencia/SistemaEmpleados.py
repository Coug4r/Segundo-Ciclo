class Empleado:
    def __init__(self, nombre, salario):
        self.__nombre = nombre
        self.__salario = salario
    @property
    def nombre(self):
        return self.__nombre
    @nombre.setter
    def nombre(self,nuevo_nombre):
        self.__nombre = nuevo_nombre
    
    def salario(self, salarioAct):
        if salarioAct>0:
            self.__salario = salarioAct
            print("Salario actualizado")
        else:
            print("Erro el valor debe ser mayor a 0")
    def mostrar_info(self):
        print("Nombre:", self.__nombre)
        print("Salario:", self.__salario)
