# Vaccination registration system 
Welcome to the first part of Team three for
a Vaccination registration system ! 
This document provides detailed instructions 
on how to get your development environment set 
up, initialize the project, and configure your 
workflow for effective collaboration.

## Getting Started
These instructions will guide you through setting up your local environment, downloading the project, and starting development.

## Prerequisites
Git: Download & Install [Git](https://git-scm.com/download/win). Git is required to clone the repository and manage your contributions.

## Initial Setup
### 1.Clone the repository
First, you'll need to clone the repository to your local machine. Open a terminal IN THE FOLDER YOU WANT THE PROJECT TO BE SAVED and run the following command.
 ```bash
git clone https://github.com/GTGH-accenture-uom-2/Team3-part1.git
```

### 2. Navigate to Your Project Directory.
Change into the project directory with:
 ```bash
cd Team3-part1
```
### 3.Check Out the Main Branch.
 ```bash
git checkout main
```
### 4.Pull the Latest Changes (not mandatory)
Make sure your local main branch is up to date with the remote repository:
 ```bash
git pull origin main
```

## Setting Up Your Development Branch

### 1.Create and Check Out a New Branch
Create a new branch for your feature or fix and switch to it with:
 ```bash
git checkout -b your-branch-name
```
Replace your-branch-name with a descriptive name for your branch (e.g., Leonidas,Kiki etc).

### 2.Push the New Branch to GitHub
After making your first commit in your branch, push it to GitHub to make it available to others:
 ```bash
git push -u origin your-branch-name
```
This command pushes your branch to the remote repository and sets it to track the remote branch.

## Pushing Changes from your local repo to remote branch

With cmd open and your folder checked-out.

### 1.Stage Your Changes
Stage all changes without specifying files. 
 ```bash
git add .
```

### 2.Commit the Changes
After staging the changes, you need to commit them with a message describing what you've changed. Good commit messages are crucial for collaborative work as they provide context to others about what the changes do.
 ```bash
git commit -m "Describe the changes you've made"
```

### 3.Push Your Commit to GitHub
Use the git push command to push your commit. If this is the first time you're pushing this branch, you'll need to set the upstream branch with the -u option, which links your local branch to a branch on the remote repository.
 ```bash
git push -u origin your-branch-name
```
Replace your-branch-name with the name of your branch. This command not only pushes your branch but also sets it to track the remote branch, meaning in the future, you can simply use git push without specifying the branch.
