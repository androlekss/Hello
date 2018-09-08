# Hello
hello RESET
[![Build Status](https://travis-ci.org/androlekss/Hello.svg?branch=master)](https://travis-ci.org/androlekss/Hello)

1.  Install Vagrant and VirtualBox

        sudo apt-get install virtualbox
        sudo apt-get install vagrant
2.  Click Clone or download.
3.  Copy the URL provided.
4.  Open your command line or Terminal application and enter the directory where you would like to copy the repository.

        git clone https://github.com/androlekss/Hello.git
        
5. Navigate into the directory of the repository you just created.
6. Finally run the following command to start your box.

         vagrant up
         
7. Now connect to you newly created rest api server using your browser and following command

        http://localhost:8090/hello/contacts?nameFilter=^A.*$