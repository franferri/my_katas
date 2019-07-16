# Python 101

## This repo gives you a few files with basic python code and tests, also .gitignore, and instructions to create a Python project, so, if you like to get to know a bit more Python you can start fast.

* Clone this very repo and cd to this folder
~~~~
    git clone XXXXXXXXXXX
    cd kata-new-python-project
~~~~
* Or create a new project from scratch
~~~~
    # rm -rf YOURPROJECTPARENTFOLDER
    mkdir YOURPROJECTPARENTFOLDER
    cd YOURPROJECTPARENTFOLDER
~~~~

## Lets start
* Check your python version
~~~~
    python3 --version
~~~~
* We create the project environment
~~~~
    python3 -m venv venv --clear
~~~~
* We activate the environment
~~~~
    source venv/bin/activate
~~~~
* Update pip for the environment
~~~~
    # updating pip this way works always and fix deprecated versions problems
    curl https://bootstrap.pypa.io/get-pip.py | python

    pip install --upgrade pip
    pip install --upgrade setuptools
~~~~
* Install a example dependency in the env
~~~~
    pip install requests
    pip show requests

    pip list
~~~~
* Save the requirements in a text file
~~~~
    pip freeze > requirements.txt
~~~~
* To deactivate
~~~~
    # deactivate
~~~~
* Make sure you pin your packages: https://nvie.com/posts/pin-your-packages/
* Use always ==, don't use >=
~~~~
    cat requirements.txt
~~~~

## Included example files

Python needs the file '__init__.py' in every folder to make it a valid python module
* .gitignore
* example/* some busines logic
* tests/example/* some example tests over the example business logic

## Share an existent Python project

* Check your python version
* Create the project environment
* Activate the environment
* Update pip for the environment
* Install the requirements with the following line
~~~~
    pip install -r requirements.txt
~~~~
* Deactivate

## How to run the tests from console

* The following needs to be run **in the parent folder**, not inside the tests folder, so it will succeed importing the referenced files
~~~~
    # deactivate
    python3 -m unittest discover
    python3 -m unittest tests/example/test_bank_account.py
    python3 -m unittest tests.example.test_bank_account.BankAccountTestCase
    python3 -m unittest tests.example.test_bank_account.BankAccountTestCase.test_have_the_balance_increased_after_a_deposit
~~~~
More examples here: https://docs.python.org/3/library/unittest.html#command-line-interface

## How to run the tests from the PyCharm

    * Open the project in Pycharm
    * Right click on the tests folders
    * Run 'Unittests in tests' (**will fail**)
    * Edit run configurations -> Working directory -> Remove the ending "/tests"
    * Right click on the tests folders again
    * Run 'Unittests in tests' (**will succeed**)

## How to add a dependency to your project

    source venv/bin/activate
    pip install --upgrade pip
    pip install <dependency_name>
    pip show <dependency_name>
    pip list
    pip freeze > requirements.txt
    deactivate

## Challenge, can you add a simple mock?
How to do it: https://docs.python.org/3/library/unittest.mock.html
Advanced read: https://martinfowler.com/articles/mocksArentStubs.html

## Where to continue with your idea?
https://realpython.com/