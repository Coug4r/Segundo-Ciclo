# Este archivo indica que "empleados" es un paquete.
# Aquí puedes importar y exponer las clases principales.

from .empleado import Empleado
from .docente import Docente
from .administrativo import Administrativo

# Control de lo que se exporta con import *
__all__ = ["Empleado", "Docente", "Administrativo"]
