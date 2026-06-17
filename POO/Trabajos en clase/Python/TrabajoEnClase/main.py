from empleados.docente import Docente
from empleados.administrativo import Administrativo

def main():
    docente1 = Docente("Carlos Pérez", 1200, "Programación")
    administrativo1 = Administrativo("Ana Gómez", 950, "Talento Humano")

    print(docente1.mostrar_info())
    print(administrativo1.mostrar_info())

    # Probando validaciones
    try:
        docente1.salario = -500   # ❌ Error: salario negativo
    except ValueError as e:
        print("Error:", e)
        
    try:
        administrativo1.departamento = ""  # ❌ Error: texto vacío
    except ValueError as e:
        print("Error:", e)

if __name__ == "__main__":
    main()
