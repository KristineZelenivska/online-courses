### How to start
You need github account, git, node and npm to be installed (npm will be installed with node).
github: [https://github.com/]
git: [https://git-scm.com/downloads]
node: [https://nodejs.org/en/download]

In terminal: 
`git clone https://github.com/KristineZelenivska/online-courses.git`
after that 
`cd online-courses` to go into project's folder
`npm install` to install packages needed for the project. Those are listed in package.json file

Now you can run 
`npm start`
Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
The page will reload when you make changes.\
You may also see any errors in the console.

### Some more notes
New page is created under src/pages with PageName.js file

If page is big, it's better to be splitted into smaller components placed in src/components.

Once you've build your page, appropriate route should be placed in src/App.js similar to other already existing. 

All functionality in pages or components goes before return.
In return section there should be one wrapper for all page. You can return only one thing, for example <div></div> but you can put as much as you want in it.
