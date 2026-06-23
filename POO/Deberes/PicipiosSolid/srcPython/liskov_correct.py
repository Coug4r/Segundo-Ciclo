# Ejecutar: python liskov_correct.py
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def area(self): pass

class Rectangle(Shape):
    def __init__(self, w, h): self.w, self.h = w, h
    def area(self): return self.w * self.h

class Square(Shape):
    def __init__(self, side): self.side = side
    def area(self): return self.side * self.side

def imprimir_area(s: Shape):
    print("Area:", s.area())

if __name__ == "__main__":
    r = Rectangle(5,4)
    s = Square(5)
    imprimir_area(r)
    imprimir_area(s)
