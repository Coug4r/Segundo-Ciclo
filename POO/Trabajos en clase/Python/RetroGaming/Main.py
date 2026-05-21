import Inventario
import VideoJuego
def main(): 
    Inventario1 = Inventario.Inventario()
    opcion = 0
    while opcion!=4:
        try:
            opcion = int(input("1.Agregar videojuego a invetario\n2.Eliminar videouego de invetario\n3.Mostrar Invetario\n4.Respaldar datos\n5.Cargar datos\n6.Salir\nEsoja una opcion: "))
        except ValueError: 
            print("Debe escojer una opcion valida\n")
            continue
        match opcion:
            case 1:
                Inventario1.agregar_videojuego()
            case 2:
                eliminar = input("Ingrese el nombre del videojuego a eliminar: ")
                Inventario1.eliminar_videojuego(eliminar)
            case 3:
                Inventario1.mostrar_inventario()
            case 4:
                archivo = input("Ingrese el nombre del archivo: ")
                Inventario1.guardarDatos(archivo)
            case 5:
                archivo = input("Nombre del archivo: ")
                Inventario1.cargarDatos(archivo)
            case 6:
                break    
if __name__ == "__main__":
    main()  