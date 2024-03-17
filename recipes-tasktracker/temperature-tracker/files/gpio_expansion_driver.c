#include <linux/module.h>
#include <linux/of_device.h>
#include <linux/kernel.h>
#include <linux/delay.h>
#include <linux/gpio/consumer.h>
#include <linux/platform_device.h>

struct gpio_desc *gpio14;

static int gpio_init_probe(struct platform_device *pdev)
{
   int i = 0;

   printk("GPIO example init\n");

   /* "gpioexpansion" label is matching the device tree declaration. OUT_LOW is the value at init */
   gpio14 = devm_gpiod_get(&pdev->dev, "gpioexpansion", GPIOD_OUT_LOW);

   while (i < 10)
   {
	ssleep(1);
	gpiod_set_value(gpio14, 1);

	ssleep(1);
	gpiod_set_value(gpio14, 0);

	i++;
   }

   return(0);
}

static int gpio_exit_remove(struct platform_device *pdev)
{
   printk("GPIO example exit\n");

   return(0);
}

/* this structure does the matching with the device tree */
/* if it does not match the compatible field of DT, nothing happens */
static struct of_device_id gpio_expansion_match[] = {
    {.compatible = "st,gpioexpansion"},
    {/* end node */}
};

static struct platform_driver gpio_expansion_driver = {
    .probe = gpio_init_probe,
    .remove = gpio_exit_remove,
    .driver = {
        .name = "gpio_expansion_driver",
                .owner = THIS_MODULE,
                .of_match_table = gpio_expansion_match,
    }
};

module_platform_driver(gpio_expansion_driver);

MODULE_AUTHOR("Bernard Puel, Mike Salmela");
MODULE_DESCRIPTION("Gpio example");
MODULE_LICENSE("GPL");
MODULE_ALIAS("platform:gpio_expansion_driver");
