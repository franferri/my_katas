Python 101

## Create a new project

    # rm -rf kata-new-python-project
    mkdir kata-new-python-project
    cd kata-new-python-project

* We create the project environment

    python3 -m venv venv

* We activate the environment in this bash

    source venv/bin/activate

* Install the requirements in the env

    pip install --upgrade pip
    pip install requests bs4
    pip list

    pip show requests
    pip show bs4

* Save the requirements in a text file

	cd ..
    pip freeze > requirements.txt

* To deactivate

    # deactivate

* Make sure you pin your packages: https://nvie.com/posts/pin-your-packages/
* Use always ==, don't use >=

    cat requirements.txt

## .gitignore

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

## Share a Python

    git clone kata-new-python-project

    cd kata-new-python-project
    python3 -m venv venv
    source venv/bin/activate

    pip install --upgrade pip
    pip install -r ../requirements.txt

