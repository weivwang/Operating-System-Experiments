#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

//

int main()
{
    int cnt = 0;
    printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
    pid_t p1 = fork(); //创建子进程p1，会执行和父进程相同的代码
    if (p1 == 0)
    {
        printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
        cnt++;
    }
    else if (p1 > 0)
    {

        printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
    }
    else
    {
        printf("进程创建失败\n");
    }

    pid_t p2 = fork();
    if (p2 == 0)
    {
        printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
        cnt++;
    }
    else if (p2 > 0)
    {
        printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
    }
    else
    {
        printf("进程创建失败\n");
    }
    pid_t p3 = fork();
    if (p3 == 0)
    {
        printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
        cnt++;
    }
    else if (p3 > 0)
    {
        printf("childpid = %d, parentpid = %d\n", getpid(), getppid());
    }
    else
    {
        printf("进程创建失败\n");
    }

    printf("cnt = %d\n", cnt);
    return 0;
}
