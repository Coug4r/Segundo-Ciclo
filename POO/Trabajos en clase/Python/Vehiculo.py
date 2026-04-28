class Vehiculo:
    def __init__(self, marca, modelo, anio, tipo_vehiculo,multas):
        self.marca = marca
        self.modelo = modelo
        self.anio = anio
        self.tipo_vehiculo = tipo_vehiculo
        self.multas = multas

    def mostrar_informacion(self):
        print(f"Marca: {self.marca}")
        print(f"Modelo: {self.modelo}")
        print(f"Año: {self.anio}")
        print(f"Tipo de vehículo: {self.tipo_vehiculo}")
        print(f"Multas: {self.multas}")

    def calcular_precio_matricula(self):
        #Del 2026 al 2021 pagan 1200, del 2020 al 2015 pagan 700 y del 2014 al 2010 pagan 100
        match self.anio:
            case 2026 | 2025 | 2024 | 2023 | 2022 | 2021:
                matricula = 1200
            case 2020 | 2019 | 2018 | 2017 | 2016 | 2015:
                matricula = 700
            case 2010 | 2011 | 2012 | 2013 | 2014:
                matricula = 100
        return matricula + self.pago_impuestos()

    def pago_impuestos(self):
        match self.tipo_vehiculo:
            case "auto":
                rodaje = 18
                prefectura = 18
            case "Camioneta":
                rodaje = 22
                prefectura = 22
            case "camion":
                rodaje = 43
                prefectura = 43
            case "taxi" | "bus":
                rodaje = 41
                prefectura = 0
        impuestos = rodaje + prefectura
        return impuestos
    def pago_multas(self):
        match self.multas:
            case "Sin multas":
                multa = 0
            case "Uso telefono":
                multa = 59
            case "Conducir en estado etilico":               
                multa = 452
            case "Estacionar donde no se debe":
                multa = 63
        return multa

        


# Ejemplo de uso
if __name__ == "__main__":
    mi_vehiculo = Vehiculo("Toyota", "Corolla", 2020, "auto", "Conducir en estado etilico")
    mi_vehiculo.mostrar_informacion()
    mi_vehiculo.calcular_precio_matricula()
    print(f"Precio de matrícula: ${mi_vehiculo.calcular_precio_matricula()}")

    print("o|-----------------------------|o")
    mi_vehiculo2 = Vehiculo("Ford", "F-150", 2026, "Camioneta", "Estacionar donde no se debe")
    mi_vehiculo2.mostrar_informacion()
    print(f"Precio de matrícula: ${mi_vehiculo2.calcular_precio_matricula()}")

    print("o|-----------------------------|o")
    mi_vehiculo3 = Vehiculo("Mercedes-Benz", "Actros", 2014, "camion", "Uso telefono")
    mi_vehiculo3.mostrar_informacion()
    print(f"Precio de matrícula: ${mi_vehiculo3.calcular_precio_matricula()}")
    
    print("o|-----------------------------|o")
    mi_vehiculo4 = Vehiculo("Volkswagen", "Transporter", 2018, "bus", "Sin multas")
    mi_vehiculo4.mostrar_informacion()      
    print(f"Precio de matrícula: ${mi_vehiculo4.calcular_precio_matricula()}")