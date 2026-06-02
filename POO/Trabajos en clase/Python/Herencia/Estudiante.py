#Estudiante heredad de persona
from Persona import Persona
class Estudiante(Persona):
    def __init__(self,nombre,edad,carrera,proceso):
        super().__init__(nombre,edad)
        self.carrera = carrera
        self.proceso = proceso
    def get_carrera(self):
        return self.carrera 
    def get_proceso(self):
        return self.proceso
    def set_carrera(self,carrera):
        self.carrera = carrera
    def set_proceso(self,proceso):
        self.proceso = proceso
    def estudiar(self):
        print(f"{self.nombre} esta estudiando")
    def mostrarInfo(self):
        super().mostrarInfo()
        print(f"Carrera: {self.carrera}")
        print(f"Proceso: {self.proceso}")
    
    