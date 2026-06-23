# Ejecutar: python single_responsibility_correct.py

class Validador:
    def validar(self, orden):
        return orden is not None and len(orden['items']) > 0

class Calculador:
    def total(self, orden):
        return sum(i['price'] * i['qty'] for i in orden['items'])

class Repositorio:
    def guardar(self, orden):
        print("Orden guardada:", orden)

class Procesador:
    def __init__(self, validador, calculador, repo):
        self.validador = validador
        self.calculador = calculador
        self.repo = repo

    def procesar(self, orden):
        if not self.validador.validar(orden):
            print("Orden inválida"); return
        print("Total:", self.calculador.total(orden))
        self.repo.guardar(orden)

if __name__ == "__main__":
    orden = {'items':[{'price':10.0,'qty':2,'name':'A'}]}
    p = Procesador(Validador(), Calculador(), Repositorio())
    p.procesar(orden)
