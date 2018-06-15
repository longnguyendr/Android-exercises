package fi.jamk.fragmentsexercise;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class EmployeesData {
    public static ArrayList<Employee> employees  = new ArrayList<>();
    public MainActivity mActivity;
    public EmployeesData(MainActivity activity) {
        this.mActivity = activity;
        employees.add(new Employee("Baker","Thomas","48-(692)270-0904","tbaker0@baidu.com","employee01","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien."));
        employees.add(new Employee("Roberts","Mary","33-(636)973-7897","mroberts1@java.com","employee02","Mauris varius diam vitae arcu. Sed arcu lectus auctor vitae, consectetuer et venenatis eget velit. "));
        employees.add(new Employee("Gordon","Tina","46-(326)779-1897","tgordon0@zdnet.com","employee03","Sed augue orci, lacinia eu tincidunt et eleifend nec lacus. Donec ultricies nisl ut felis, suspendisse potenti. Lorem ipsum ligula ut hendrerit mollis, ipsum erat vehicula risus, eu suscipit sem libero nec erat. "));
        employees.add(new Employee("Daniels","Fred","86-(347)398-2400","fdaniels1@rambler.ru","employee04","Aliquam erat volutpat. Sed congue augue vitae neque. Nulla consectetuer porttitor pede. Fusce purus morbi tortor magna condimentum vel, placerat id blandit sit amet tortor."));
        employees.add(new Employee("Hunt","Anna","31-(353)193-8896","ahunt2@biblegateway.com","employee05","Mauris sed libero. Suspendisse facilisis nulla in lacinia laoreet, lorem velit accumsan velit vel mattis libero nisl et sem."));
        employees.add(new Employee("Lynch","Cheryl","351-(783)624-3339","clynch3@comcast.net","employee06","Proin interdum maecenas massa turpis sagittis in, interdum non lobortis vitae massa. Quisque purus lectus, posuere eget imperdiet nec sodales id arcu. Vestibulum elit pede dictum eu, viverra non tincidunt eu ligula."));
        employees.add(new Employee("Robertson","Eugene","62-(737)708-5866","erobertson4@prlog.org","employee07","Nam molestie nec tortor. Donec placerat leo sit amet velit. Vestibulum id justo ut vitae massa. "));
        employees.add(new Employee("Reyes","Richard","84-(802)216-7168","rreyes5@flavors.me","employee08","Proin in dolor mauris consequat aliquam. Donec ipsum, vestibulum ullamcorper venenatis augue. Aliquam tempus nisi in auctor vulputate, erat felis pellentesque augue nec, pellentesque lectus justo nec erat."));
        employees.add(new Employee("Cruz","Lois","7-(443)215-2632","lcruz6@imdb.com","employee09","Aliquam et nisl. Quisque sit amet dolor in justo pretium condimentum."));

        employees.add(new Employee("Day","Marilyn","58-(502)202-1176","mday7@spiegel.de","employee01","Vivamus placerat lacus vel vehicula scelerisque, dui enim adipiscing lacus sit amet sagittis, libero enim vitae mi. In neque magna posuere, euismod ac tincidunt tempor est."));
        employees.add(new Employee("Wallace","Howard","62-(117)213-1523","hwallace8@google.fr","employee02","Ut suscipit nisi eu purus. Proin ut pede mauris eget ipsum. Integer vel quam nunc commodo consequat. Integer ac eros eu tellus dignissim viverra. Maecenas erat aliquam erat volutpat."));
        employees.add(new Employee("Brooks","Raymond","234-(713)560-0721","rbrooks9@parallels.com","employee03","Ut venenatis ipsum quis turpis. Integer cursus scelerisque lorem. Sed nec mauris id quam blandit consequat. Cras nibh mi hendrerit vitae, dapibus et aliquam et magna. Nulla vitae elit."));
        employees.add(new Employee("Nelson","Scott","965-(926)322-8896","snelsona@pcworld.com","employee04","Cras lobortis sem ultrices leo. Donec magna fusce ac ante. Nullam est nisi blandit eget, suscipit vitae posuere quis ante. "));
        employees.add(new Employee("Powell","Edward","86-(273)809-9559","epowellb@usda.gov","employee05","Quisque vitae tortor tellus feugiat adipiscing. Morbi ac elit et diam bibendum bibendum. Suspendisse id diam, donec adipiscing vulputate metus. Cras pellentesque vestibulum sem."));
        employees.add(new Employee("Mason","Daniel","48-(680)108-1915","dmasonc@myspace.com","employee06","Maecenas ut elit quis nisl vestibulum bibendum. Aenean eu erat quis turpis consequat vehicula. Morbi lacus velit, tristique ut iaculis volutpat in velit."));
        employees.add(new Employee("Coleman","Wanda","57-(424)651-4149","wcolemand@theglobeandmail.com","employee07","Donec nec dui, in viverra tristique sapien. Suspendisse tincidunt consequat ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae."));
        employees.add(new Employee("Cooper","Mary","86-(467)947-3718","mcoopere@freewebs.com","employee08","Etiam molestie hendrerit risus. Curabitur venenatis risus varius odio. Quisque elit ante, lacinia eget mollis sed, fermentum nec nisl. Nullam volutpat odio dolor tempor posuere."));
        employees.add(new Employee("Morris","Nicole","7-(130)646-6900","nmorrisf@youtu.be","employee09","Suspendisse et elit vel sem interdum consequat. Aenean pulvinar nisl vel neque. Morbi mi ac neque ullamcorper dignissim. Nulla suscipit ipsum. Duis adipiscing turpis vitae turpis."));
    }

    class Employee {
        public String lastname;
        public String firstname;
        public String phone;
        public String email;
        public String image;
        public Drawable drawable;
        public String text;

        public Employee(String lastname, String firstname, String phone, String email, String image, String text) {
            this.lastname = lastname;
            this.firstname = firstname;
            this.phone = phone;
            this.email = email;
            this.image = image;
            Resources res = mActivity.getResources();
            drawable = res.getDrawable(res.getIdentifier(image,"drawable",mActivity.getPackageName()),mActivity.getTheme());
            this.text = text;
        }

    }
}