from Persona import Persona 
class Docente(Persona):
    def __init__(self,nombre,edad,especialidad,salario):
        super().__init__(nombre,edad)
        self.especialidad = especialidad
        self.salario = salario
    def get_especialidad(self):
        return self.especialidad    
    def get_salario(self):
        return self.salario
    def set_especialidad(self,especialidad):
        self.especialidad = especialidad
    def set_salario(self,salario):
        self.salario = salario
    def registrarNota(self):
        print(f"{self.nombre} esta registrando notas")
    def mostrarInfo(self):
        super().mostrarInfo()
        print(f"Especialidad: {self.especialidad}")
        print(f"Salario: {self.salario}")