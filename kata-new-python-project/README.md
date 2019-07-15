# Python 101

## Create a new project from scratch
~~~~
    # rm -rf YOURPROJECTPARENTFOLDER
    mkdir YOURPROJECTPARENTFOLDER
    cd YOURPROJECTPARENTFOLDER
~~~~

* We create the project environment
~~~~
    python3 -m venv venv
~~~~
* We activate the environment in this bash
~~~~
    source venv/bin/activate
~~~~
* Install the requirements in the env
~~~~
    pip install --upgrade pip
    pip install requests bs4
    pip list

    pip show requests
    pip show bs4
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
## .gitignore
~~~~
    curl https://raw.githubusercontent.com/github/gitignore/master/Python.gitignore --output .gitignore
    
    echo '' >> .gitignore
    echo '# Apple OSX' >> .gitignore
    echo '.DS_Store' >> .gitignore
    echo '' >> .gitignore
    echo '# Windows' >> .gitignore
    echo 'Thumbs.db' >> .gitignore
    echo '' >> .gitignore
    echo '# IntelliJ' >> .gitignore
    echo '.idea/' >> .gitignore
    echo '*.ipr' >> .gitignore
    echo '*.iws' >> .gitignore
    echo '*.iml' >> .gitignore
    echo '' >> .gitignore
    echo '# eclipse' >> .gitignore
    echo '.settings/' >> .gitignore
    echo '.classpath' >> .gitignore
    echo '.project' >> .gitignore
~~~~
## Share an existent Python project
~~~~
    git clone YOURPROJECTPARENTFOLDER

    cd YOURPROJECTPARENTFOLDER
    python3 -m venv venv
    source venv/bin/activate

    pip install --upgrade pip
    pip install -r ../requirements.txt
~~~~
## Let's add some python code and tests just for fun
~~~~
    mkdir example
    cd example
    touch __init__.py
    curl https://raw.githubusercontent.com/franferri/your-codingdojos-katas/master/your-kata-project-using-python3/example/bank_account.py --output bank_account.py
    
    cd ..
    mkdir -p tests/example
    cd tests
    touch __init__.py
    curl https://raw.githubusercontent.com/franferri/your-codingdojos-katas/master/your-kata-project-using-python3/tests/test_my_class.py --output test_my_class.py
    cd example
    touch __init__.py
    curl https://raw.githubusercontent.com/franferri/your-codingdojos-katas/master/your-kata-project-using-python3/tests/example/test_bank_account.py --output test_bank_account.py
    
    cd ../..
~~~~
## How to run the tests from console
* The following needs to be run in the parent folder, not inside the tests folder, so it will succeed importing the referenced files
~~~~
    cd YOURPROJECTPARENTFOLDER
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
    pip list
    deactivate

## Challenge, can you add a simple mock?
How to do it: https://docs.python.org/3/library/unittest.mock.html
Advanced read: https://martinfowler.com/articles/mocksArentStubs.html

## Where to continue with your idea?
https://realpython.com/