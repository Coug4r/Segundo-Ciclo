class Vehiculo:
    def __init__(self, marca, modelo, anio):
        self.marca = marca
        self.modelo = modelo
        self.anio = anio
    def mostrar_informacion(self):
        print(f"Marca: {self.marca}")
        print(f"Modelo: {self.modelo}")
        print(f"Año: {self.anio}")  

# Ejemplo de uso
if __name__ == "__main__":
    mi_vehiculo = Vehiculo("Toyota", "Corolla", 2020)
    mi_vehiculo.mostrar_informacion()