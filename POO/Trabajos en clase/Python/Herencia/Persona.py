class Persona:
    def __init__(self,nombre,edad):
        self.nombre = nombre
        self.edad = edad
    def get_nombre(self):
        return self.nombre
    def get_edad(self):
        return self.edad
    def set_nombre(self,nombre):
        self.nombre = nombre    
    def set_edad(self,edad):
        self.edad = edad    
    def mostrarInfo(self):
        print(f"Nombre: {self.nombre}")
        print(f"Edad: {self.edad}") 

        