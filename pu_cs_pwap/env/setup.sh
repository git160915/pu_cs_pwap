#!/bin/sh

# sudo apt-get update
sudo apt-get update && \
sudo apt-get install -y vim && \
sudo apt-get install -y htop && \
sudo apt-get install -y neofetch && \
sudo apt-get install -y vim-airline && \
sudo apt-get install -y fonts-powerline


# Install zsh in Ubuntu using an apt package manager
#sudo apt install -y zsh

# We can also check with cat /etc/shells , to see if Zsh in available on the valid login shells. 
# If Zsh has been setup, /usr/bin/zsh will exist in the list of valid login shells.

#cat /etc/shells


# Install oh my zsh using curl
#sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"

# Now, edit the ZSH_THEME in ~/.zshrc file into: 
# ZSH_THEME="powerlevel10k/powerlevel10k"

# Install powerlevel10k
git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
sed -i 's/ZSH_THEME=\"devcontainers\"/ZSH_THEME=\"powerlevel10k\/powerlevel10k\"/g' ~/.zshrc

# Download zsh-autosuggestions
# AND
# Download zsh-syntax-higlighting
git clone https://github.com/zsh-users/zsh-autosuggestions.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/plugins/zsh-autosuggestions && \
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting


# Edit ~/.zshrc file, find plugins=(git) replace plugins=(git) with :
# plugins=(git zsh-autosuggestions zsh-syntax-highlighting)
sed -i 's/plugins=(git)/plugins=(git zsh-autosuggestions zsh-syntax-highlighting)/g' ~/.zshrc

exec zsh
