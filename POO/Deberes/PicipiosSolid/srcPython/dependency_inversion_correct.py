# Ejecutar: python dependency_inversion_correct.py
from abc import ABC, abstractmethod

class Logger(ABC):
    @abstractmethod
    def log(self, msg): pass

class ConsoleLogger(Logger):
    def log(self, msg): print("LOG:", msg)

class Service:
    def __init__(self, logger: Logger):
        self.logger = logger
    def do_work(self):
        self.logger.log("Iniciando trabajo")

if __name__ == "__main__":
    svc = Service(ConsoleLogger())
    svc.do_work()
