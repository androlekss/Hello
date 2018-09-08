# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<END

     sudo apt-get update
     sudo apt-get -y install postgresql
     sudo apt-get -y install postgresql-contrib

     sudo -u postgres psql -c "ALTER USER postgres PASSWORD 'postgres';"

     sudo add-apt-repository -y ppa:webupd8team/java
     sudo apt-get -y update
     sudo apt-get -y upgrade
         echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
         echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
     sudo apt-get -y install oracle-java8-installer
     sudo apt-get install -y maven git
     git clone https://github.com/androlekss/Hello.git
     cd Hello
     mvn spring-boot:run
END

Vagrant.configure(2) do |config|

    config.vm.box = "ubuntu/trusty64"
    config.vm.box_check_update = false
    config.vm.hostname = "testing"
    config.vm.network "private_network", type: "dhcp"
    config.vm.define "testing"
    config.vm.network  "forwarded_port", guest: 8090, host: 8090, auto_correct: true

    config.vm.provider "virtualbox" do |vb|
       vb.gui = false
       vb.memory = "2048"
    end

     config.vm.provision "shell", inline: $script



end
