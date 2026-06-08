class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def mostrar_datos(self):
        print("Nombre:", self.nombre)
        print("Edad:", self.edad)

class Estudiante(Persona):
    def __init__(self, nombre, edad, carrera, semestre):
        super().__init__(nombre, edad)
        self.carrera = carrera
        self.semestre = semestre

    def mostrar_estudiante(self):
        self.mostrar_datos()
        print("Carrera:", self.carrera)
        print("Semestre:", self.semestre)

# Ejemplo
est1 = Estudiante("Juan Pérez", 20, "Computación", 4)
est1.mostrar_estudiante()
