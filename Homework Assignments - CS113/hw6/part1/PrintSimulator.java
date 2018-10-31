package edu.miracosta.cs113.hw6.part1;

/* Programmed By : Robert Esposito
   Date          : 03/12/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #6

   Description: This program will simulate printing with different
   printer setups. Print jobs are added to the queue every minute
   and are printed in priority of small jobs, medium jobs, and then
   large jobs. When a print job is done, a new print job is pulled
   off the queue until 100 jobs have been printed. It then displays
   how long it took to print all of the print jobs. Each time through
   the while loop represents 6 seconds, since the printer can print 1
   page every 6 seconds.

 */
public class PrintSimulator
{
    static PrintQueue<PrintJob> small = new PrintQueue<>();
    static PrintQueue<PrintJob> medium = new PrintQueue<>();
    static PrintQueue<PrintJob> large = new PrintQueue<>();

    public static void main(String[] args)
    {
        boolean printingComplete = false;
        int timer = 0;
        int jobsToPrint = 0;
        int numJobs = 0;
        int pageCount1 = 0;
        int totalPages = 0;
        int onePrinterTime = 0;
        int twoPrinterTime = 0;
        int threePrinterTime = 0;

        /** Simulation with 1 printer */
        System.out.println("----  One Printer  ----");
        while (!printingComplete)
        {
            /** If 100 jobs have been added, there is no more pages to be printed, and all the queues are empty,
             *  the simulation is ended.
             */
            if (jobsToPrint == 100 && pageCount1 == 0 && small.empty() && medium.empty() && large.empty())
            {
                printingComplete = true;
            }

            else
            {
                /** Adds a new print job every minute (10 loops) */
                if (timer % 10 == 0 && jobsToPrint < 100)
                {
                    addJob();
                    numJobs++;
                    jobsToPrint++;
                    System.out.println("Job number " + numJobs + " added.");
                }

                if (pageCount1 == 0)
                {
                    pageCount1 = getPages();
                    totalPages = pageCount1;
                    System.out.println(totalPages + " pages on Printer 1.");
                }
                else
                {
                    pageCount1--;
                }
                timer++;
            }
        }

        onePrinterTime = timer*6;
        System.out.println("Total print time for 1 printer: " + onePrinterTime + " seconds");

        /** Simulation with 2 printers */
        jobsToPrint = 0;
        numJobs = 0;
        timer = 0;
        pageCount1 = 0;
        printingComplete = false;
        int pageCount2 = 0;
        int totalPages2 = 0;

        System.out.println("\n\n----  Two Printer  ----");
        while (!printingComplete)
        {
            /** If 100 jobs have been added, there is no more pages to be printed, and all the queues are empty,
             *  the simulation is ended.
             */
            if (jobsToPrint == 100 && pageCount1 == 0 && pageCount2 == 0 && small.empty() && medium.empty()
                    && large.empty())
            {
                printingComplete = true;
            }

            else
            {
                if (timer % 10 == 0 && jobsToPrint < 100)
                {
                    addJob();
                    numJobs++;
                    jobsToPrint++;
                    System.out.println("Job number " + numJobs + " added.");
                }

                if (pageCount1 == 0)
                {
                    pageCount1 = getPages();
                    totalPages = pageCount1;
                    System.out.println(totalPages + " pages on Printer 1.");
                }
                else
                {
                    pageCount1--;
                }

                if (pageCount2 == 0)
                {
                    pageCount2 = getPages();
                    totalPages2 = pageCount2;
                    System.out.println(totalPages2 + " pages on Printer 2.");
                }
                else
                {
                    pageCount2--;
                }
                timer++;
            }
        }

        twoPrinterTime = timer*6;
        System.out.println("Total print time for 2 printer: " + twoPrinterTime + " seconds");

        /** Simulation with 3 printers. */
        jobsToPrint = 0;
        numJobs = 0;
        timer = 0;
        pageCount1 = 0;
        pageCount2 = 0;
        printingComplete = false;
        int pageCount3 = 0;
        int totalPages3 = 0;

        System.out.println("\n\n----  Three Printer  ----");
        while (!printingComplete)
        {
            /** If 100 jobs have been added, there is no more pages to be printed, and all the queues are empty,
             *  the simulation is ended.
             */
            if (jobsToPrint == 100 && pageCount1 == 0 && pageCount2 == 0 && pageCount3 == 0 && small.empty()
                    && medium.empty() && large.empty())
            {
                printingComplete = true;

            }

            else {
                if (timer % 10 == 0 && jobsToPrint < 100)
                {
                    addJob();
                    numJobs++;
                    jobsToPrint++;
                    System.out.println("Job number " + numJobs + " added.");
                }

                if (pageCount1 == 0)
                {
                    pageCount1 = getPages();
                    totalPages = pageCount1;
                    System.out.println(totalPages + " pages on Printer 1.");
                }
                else
                {
                    pageCount1--;
                }

                if (pageCount2 == 0)
                {
                    pageCount2 = getPages();
                    totalPages2 = pageCount2;
                    System.out.println(totalPages2 + " pages on Printer 2.");
                }
                else
                {
                    pageCount2--;
                }

                if (pageCount3 == 0)
                {
                    pageCount3 = getPages();
                    totalPages3 = pageCount3;
                    System.out.println(totalPages3 + " pages on Printer 3.");
                }
                else
                {
                    pageCount3--;
                }

                timer++;
            }
        }

        threePrinterTime = timer*6;
        System.out.println("Total print time for 3 printer: " + threePrinterTime + " seconds");

        System.out.println("\n\n Totals: ");
        System.out.println("One Printer: " + onePrinterTime + " seconds");
        System.out.println("Two Printer: " + twoPrinterTime + " seconds");
        System.out.println("Three Printer: " + threePrinterTime + " seconds");

    }


    /** Adds a print job to the correct queue. */
    public static void addJob()
    {
        PrintJob job = new PrintJob();

        if (job.getPages() < 10)
        {
            System.out.println("Job added to small queue.");
            small.add(job);
        }
        else if (job.getPages() < 25)
        {
            System.out.println("Job added to medium queue.");
            medium.add(job);
        }
        else
        {
            System.out.println("Job added to large queue.");
            large.add(job);
        }
    }

    /** Pulls print jobs from the small queue until it is empty, then the medium
     * queue, then the large queue.
     * @return the number of pages in the print job.
     */
    public static int getPages()
    {
        if (small.empty())
        {
            if (medium.empty())
            {
                if (large.empty())
                {
                    return 0;
                }
                else
                {
                    int lTemp = large.peek().getPages();
                    large.poll();
                    return lTemp;
                }
            }
            else
            {
                int mTemp = medium.peek().getPages();
                medium.poll();
                return mTemp;
            }
        }
        else
        {
            int sTemp = small.peek().getPages();
            small.poll();
            return sTemp;
        }
    }
}
