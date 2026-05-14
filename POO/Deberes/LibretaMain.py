from libretaCalificaciones import LibretaCalificaciones

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
