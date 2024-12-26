# class Car:
#     def __init__(self, make, model, year):
#         self.__make = make
#         self.__model = model
#         self.__year = year
#
#     def display_info(self):
#         print(f"{self.__year} {self.__make} {self.__model}")
#
#     def set_make(self, make):
#         self.__make = make
#
#     def get_make(self):
#         return self.__make
#
# class ElectricCar(Car):
#     def __init__(self, make, model, year, battery_size):
#         super().__init__(make, model, year)
#         self.battery_size = battery_size
#
#     def display_info(self):
#         super().display_info()
#         print(f"Battery size: {self.battery_size} kWh")
#
#
if __name__ == "__main__":
    # my_car = Car("Toyota", "Sequoia", 2016)
    # my_car.display_info()
    #
    # tesla = ElectricCar("Tsla", "S5", 2025, 20)
    # tesla.display_info()
    hello = 2
    print(hello)
