import unittest

from example.bank_account import BankAccount


class BankAccountTestCase(unittest.TestCase):

    def test_have_balance_of_zero_when_created(self):
        # given
        bank_account = BankAccount()

        # then
        self.assertEqual(0, bank_account.balance())

    def test_have_the_balance_increased_after_a_deposit(self):
        # given
        bank_account = BankAccount()

        # when
        bank_account.deposit(10)

        # then
        self.assertEqual(10, bank_account.balance())


if __name__ == '__main__':
    unittest.main()
