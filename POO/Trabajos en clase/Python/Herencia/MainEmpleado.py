from docente1 import Docente
from administrativo import Administrativo

# Objetos
docente1 = Docente("Carlos Pérez", 1200, "Programación")
administrativo1 = Administrativo("Ana Gómez", 950, "Talento Humano")

print("DOCENTE")
docente1.mostrar_info()
print(f"No se puede acceder al salario ya que es privado: {docente1.salario}")
docente1.salario(-200)
docente1.salario(200)

print("\nADMINISTRATIVO")
administrativo1.mostrar_info()
print(f"No se puede acceder al salario ya que es privado: {administrativo1.salario}")
administrativo1.salario(-100)
administrativo1.salario(100)