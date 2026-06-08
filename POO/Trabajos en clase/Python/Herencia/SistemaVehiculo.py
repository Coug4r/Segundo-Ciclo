class Vehiculo:
    def __init__(self, marca, modelo):
        self.marca = marca
        self.modelo = modelo

    def mostrar_datos(self):
        print("Marca:", self.marca)
        print("Modelo:", self.modelo)

class Automovil(Vehiculo):
    def __init__(self, marca, modelo, puertas, color):
        super().__init__(marca, modelo)  # hereda atributos de Vehiculo
        self.puertas = puertas
        self.color = color

    def mostrar_automovil(self):
        self.mostrar_datos()  # reutiliza método de la clase padre
        print("Puertas:", self.puertas)
        print("Color:", self.color)

# Crear objeto
auto1 = Automovil("Toyota", "Corolla", 4, "Rojo")
auto1.mostrar_automovil()
