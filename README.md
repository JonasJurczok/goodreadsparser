# GOODREADSSCRAPER
A very simple scraper for goodreads edition details.

### Motivation
I wrote this scraper to help my sister with her bachelors thesis. It requires her to
analyze a lot of data obtained from the goodreads website. Of course obtaining the
data by hand is possible but very tedious (we are talking about reading a couple 
hundred webpages). Hence this little scraper was created.

### Distribution
This program is only available from the [GitHub releases](https://github.com/JonasJurczok/goodreadsscraper/releases).

### Prerequisites
You need to have [Java](https://www.java.com/) installed and available on the command line.

### What it does
Goodreads has a page for every book where all the editions of that book are listed, together with some metadata 
(see [this example](https://www.goodreads.com/work/editions/3060926-pride-and-prejudice?per_page=500&utf8=%E2%9C%93&expanded=true)).
This scraper now expects a list of such addresses as input. It will look at every single one of the 
provided websites and read out the following information

| Field | Description |
|-------|-------------|
| Title | The title of the book as described in the title of the webpage |
| Type | The type of each edition according to user configuration |
| Language | The language of every edition on that page |
| Ratings | The number of ratings for each edition |
| average rating | The average rating for each edition |

For ways to run and configure the program take a look at the usage section.

### Usage
To run the program simply put the jar in a folder of your choice. 
Then open a command prompt (start -> execute -> cmd under windows) and navigate to
the folder where you just put the jar.

You can now run the program with `java -jar goodreadsscraper.jar`.

To function the program needs two additional files:

#### input.txt
This file contains all the websites to look at. Simply put one URL per line into this file.

````
https://goodreads.com/book1
https://goodreads.com/book2
...
````

#### types.txt
This file contains the filter strings for the types you are looking for.
The number of different types is endless and depending on your use case you might not
be interested in some and they will also vary between books.
With this file you can define keywords (again one per line). The program will search for these
keywords on the website.
If a keyword is found the line will be split by , and then the part that contains the keyword will 
be used for the output.

````
# assuming you have Paperback in your types.txt
Paperback, 343 pages -> Paperback
Unedited Paperback, 200 pages -> Unedited Paperback
Original, Paperback, 1 page -> Paperback
````  

#### output
The output will be written to `output.csv` into the same folder.
This csv file contains the following columns (currently without header).

| title | Type | Ratings | avg. Rating | Language |
|-------|------|---------|-------------|----------|

### Disclaimer
This program has been hacked together in a couple hours to help my sister. There is
no real care gone into regarding code quality, extendability or maintainability.
I will add some tests for my own good nights rest but not more.
So.. you have been warned.

![](https://imgs.xkcd.com/comics/goto.png)
(Source: [xkcd](https://imgs.xkcd.com/comics/goto.png))