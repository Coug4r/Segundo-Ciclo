# Ejecutar: python open_closed_correct.py
from abc import ABC, abstractmethod

class Impuesto(ABC):
    @abstractmethod
    def aplicar(self, monto): pass

class SinImpuesto(Impuesto):
    def aplicar(self, monto): return monto

class IVA(Impuesto):
    def aplicar(self, monto): return monto * 1.12

class Calculador:
    def calcular(self, monto, impuesto: Impuesto):
        return impuesto.aplicar(monto)

if __name__ == "__main__":
    monto = 100.0
    calc = Calculador()
    print("Sin impuesto:", calc.calcular(monto, SinImpuesto()))
    print("Con IVA:", calc.calcular(monto, IVA()))
