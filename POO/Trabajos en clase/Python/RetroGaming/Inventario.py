import pickle
import VideoJuego
import os
class Inventario:
    def __init__(self):
        self.videojuegos = []
    def get_videojuegos(self):
        return self.videojuegos
    def agregar_videojuego(self):
        titulo = input("Ingrese el titulo del Videojuego: ")
        plataforma = input("Ingrese la plataforma del juego: ")
        anio_lanzamiento = input("Ingrese el anio de lanzamiento: ")
        precio = input("Ingrese el precio: ")
        videojuego = VideoJuego.VideoJuego(titulo,plataforma,anio_lanzamiento,precio)
        self.videojuegos.append(videojuego)
        print(f"Videojuego {titulo} guardado correctamente!\n")
    def mostrar_inventario(self):
        if not self.videojuegos:
            print("El inventario está vacío.")
        else:
            for videojuego in self.videojuegos:
                videojuego.mostrar_info()
                print("-" * 20)
    def eliminar_videojuego(self, titulo):
        for videojuego in self.videojuegos:
            if videojuego.get_titulo() == titulo:
                self.videojuegos.remove(videojuego)
                print(f"Videojuego '{titulo}' eliminado del inventario.\n")
                return
        print(f"Videojuego '{titulo}' no encontrado en el inventario.")
    
    
    def buscar_por_plataforma(self, plataforma):
        print(f"Videojuegos disponibles para la plataforma '{plataforma}':")
        for videojuego in self.videojuegos:
            if videojuego.get_plataforma().lower() == plataforma.lower():
                print(videojuego.get_titulo())
        
    def guardarDatos(self, filename):
        carpeta = "RetroGaming"
        os.makedirs(carpeta, exist_ok=True)
        ruta = os.path.join(carpeta, f"{filename}.pkl")
        with open(ruta, 'wb') as file:
            pickle.dump(self.videojuegos, file)
        print(f"Inventario guardado en '{ruta}'.\n")

    def cargarDatos(self, filename):
        carpeta = "RetroGaming"
        ruta = os.path.join(carpeta, f"{filename}.pkl")
        try:
            with open(ruta, 'rb') as file:
                self.videojuegos = pickle.load(file)
            print(f"Inventario cargado desde '{ruta}'.")
        except FileNotFoundError:
            print(f"Archivo '{ruta}' no encontrado en la carpeta RetroGaming.")
