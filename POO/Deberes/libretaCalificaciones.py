class LibretaCalificaciones:
    #constructor
    def __init__(self, estudiante, calificaciones):
        self.estudiante = estudiante
        self.calificaciones = calificaciones
        self.promedio = 0
        self.promedio_cualitativo = ""
    #Cacular promedio
    def calcular_promedio(self):
        self.promedio = sum(self.calificaciones) / len(self.calificaciones)
    #Promedio cualitativo
    def calcular_promedio_cualitativo(self):
        if 0 <= self.promedio < 3.09:
            self.promedio_cualitativo = "Regular"
        elif 3.1 <= self.promedio <= 5.09:
            self.promedio_cualitativo = "Insuficiente"
        elif 5.1 <= self.promedio <= 7.09:
            self.promedio_cualitativo = "Bueno"
        elif 7.1 <= self.promedio <= 9.09:
            self.promedio_cualitativo = "Muy Bueno"
        elif 9.1 <= self.promedio <= 10:
            self.promedio_cualitativo = "Sobresaliente"
        else:
            self.promedio_cualitativo = "Sin Rango"
    #Metodo info principal
    def info(self):
        self.calcular_promedio()
        self.calcular_promedio_cualitativo()
        print(f"\nEstudiante: {self.estudiante}")
        print(f"Promedio: {self.promedio:.2f}")
        print(f"Promedio cualitativo: {self.promedio_cualitativo}")
        print("Calificaciones: ", end=" ")
        for c in self.calificaciones:
            print(f"[{c:.2f}]", end=" ")
        print()

#Main
def main():
    nombre = input("Ingrese el nombre del estudiante: ")
    while True:
        try:
            num = int(input("Ingrese el número de calificaciones: "))
            if num <= 0:
                print("Error: el número debe ser mayor a 0\n")
                continue

            calificaciones = []
            for i in range(num):
                while True:
                    try:
                        calificacion = float(input(f"Ingrese la calificación {i+1}: "))
                        if calificacion < 0:
                            print("Error: datos negativos\n")
                        else:
                            calificaciones.append(calificacion)
                            break
                    except ValueError:
                        print("Error: ingrese un número válido\n")
            break
        except ValueError:
            print("Error: ingrese un número válido\n")

    est1 = LibretaCalificaciones(nombre, calificaciones)
    est1.info()


if __name__ == "__main__":
    main()
