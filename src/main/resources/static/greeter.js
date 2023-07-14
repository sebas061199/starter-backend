const Status = Object.freeze({
    INITIAL: { alertStyle: "alert-light" },
    SUCCESS: { alertStyle: "alert-success" },
    ERROR: { alertStyle: "alert-danger" }
});
export class Greeter {

    constructor(inputElement, outputElement) {
        // initialize
        this.text = "The greeting will appear here";
        this.status = Status.INITIAL;

        // bind html elements
        this.inputElement = inputElement;
        this.outputElement = outputElement;
    }

    async fetch() {
        const name = this.inputElement.value;
        console.log("Calling the backend to get a greeting for " + name);

        try {
            const response = await fetch("/greeting/random?name=" + name);
            console.log("Response is ok? " + response.ok + "Status code " + response.status);

            const json = await response.json();
            console.log("Got a json response: " + JSON.stringify(json));

            if (response.ok) {
                this.text = json.text;
                this.status = Status.SUCCESS;
            } else {
                this.text = "Something went wrong. Got a status " + response.status + " from the server.";
                this.status = Status.ERROR;
            }
        } catch (ex) {
            this.text = "Something went wrong. Exception message is '" + ex.message + "'";
            this.status = Status.ERROR;
        }
    }

    render() {
        const p = document.createElement("p");
        p.classList.add("alert", this.status.alertStyle);
        p.textContent = this.text;
        this.outputElement.replaceChildren(p);
    }
}
