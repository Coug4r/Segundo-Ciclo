class VideoJuego:
    def __init__(self, titulo,plataforma, año_lanzamiento,precio):
        self.titulo = titulo
        self.plataforma = plataforma
        self.año_lanzamiento = año_lanzamiento
        self.precio = precio

    ##getters y setters
    def get_titulo(self):
        return self.titulo

    def get_plataforma(self):
        return self.plataforma

    def get_año_lanzamiento(self):
        return self.año_lanzamiento
    
    def get_precio(self):
        return self.precio
    
    def set_titulo(self, titulo):
        self.titulo = titulo    

    def set_plataforma(self, plataforma):
        self.plataforma = plataforma        

    def set_año_lanzamiento(self, año_lanzamiento):
        self.año_lanzamiento = año_lanzamiento

    def set_precio(self, precio):
        self.precio = precio    

    def mostrar_info(self):
        print(f"Título: {self.titulo}")
        print(f"Plataforma: {self.plataforma}")
        print(f"Año de Lanzamiento: {self.año_lanzamiento}")
        print(f"Precio: ${self.precio}")
    