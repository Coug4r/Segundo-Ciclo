from Persona import Persona
from Estudiante import Estudiante
from Docente import Docente

persona1 = Persona("Juan",30)
estudiante1 = Estudiante("Maria",20,"Informatica","Primer Ciclo")
docente1 = Docente("Carlos",40,"Matematicas",3000)
print("---Persona----") 
persona1.mostrarInfo()
print("---Estudiante----")  
estudiante1.mostrarInfo()
estudiante1.estudiar()
print("----Docente----")
docente1.mostrarInfo()
docente1.registrarNota()

