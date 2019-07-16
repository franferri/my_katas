class BankAccount:
    _balance = 0

    def balance(self):
        return self._balance

    def deposit(self, deposit):
        self._balance = self._balance + deposit
