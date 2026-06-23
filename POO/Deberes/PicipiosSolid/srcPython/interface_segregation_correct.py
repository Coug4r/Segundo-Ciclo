# Ejecutar: python interface_segregation_correct.py
from abc import ABC, abstractmethod

class Trabajable(ABC):
    @abstractmethod
    def trabajar(self): pass

class Comible(ABC):
    @abstractmethod
    def comer(self): pass

class Humano(Trabajable, Comible):
    def trabajar(self): print("Humano trabaja")
    def comer(self): print("Humano come")

class Robot(Trabajable):
    def trabajar(self): print("Robot trabaja")

if __name__ == "__main__":
    h = Humano()
    r = Robot()
    h.trabajar(); h.comer()
    r.trabajar()
