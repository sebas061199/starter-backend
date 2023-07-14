import {Greeter} from "./greeter.js";

// bind the greeter to the input name and output element
const greeter = new Greeter(
    document.forms['form'].elements['name'],
    document.getElementById('greeter')
);

// call the greeter when the form is submitted
document.forms['form'].addEventListener('submit', async (event) => {
    event.preventDefault(); // prevent the actual form submission since we're doing a fetch here
    await greeter.fetch();
    greeter.render();
});

// initial render for the greeter
greeter.render();
