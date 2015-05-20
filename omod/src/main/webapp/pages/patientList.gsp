%{--${ ui.includeFragment("patientmodule", "patientList") }--}%

${ ui.includeFragment("patientmodule", "patientList",
        [   decoratorProvider: "patientmodule",
            decorator: "widget",
            decoratorConfig: [title: "Patient List"]
        ]) }