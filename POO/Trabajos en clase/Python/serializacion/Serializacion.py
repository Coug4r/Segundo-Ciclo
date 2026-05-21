##Serializacion 
import pickle
class Estudiante:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

# Crear un objeto de la clase Estudiante
estudiante1 = Estudiante("Juan", 20)

## with trabaja con context manager, que permite administrar recursos automáticamente.

# Serializar el objeto a un archivo
with open("estudiante.pkl", "wb") as archivo: ##wb: write binary
    pickle.dump(estudiante1, archivo) ##dump: serializa el objeto y lo escribe en el archivo
    print("\nObjeto serializado correctamente")

# Deserializar el objeto desde el archivo
with open("estudiante.pkl", "rb") as archivo: ##rb: read binary
    estudiante_cargado = pickle.load(archivo)##load: lee el objeto serializado desde el archivo y lo deserializa
    print("\nObjeto deserializado correctamente")
    print(f"\nNombre: {estudiante_cargado.nombre}, Edad: {estudiante_cargado.edad}\n")