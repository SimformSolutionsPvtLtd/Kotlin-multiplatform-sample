//
//  MainViewController.swift
//  iosApp
//
//  Created by Mohammed Hanifbiji on 22/01/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared

class MainViewController: UIViewController {

    // MARK: -  Declaring Outlets
    @IBOutlet weak var lblText: UILabel!
    
    // MARK: - View Life Cycle Methods
    override func viewDidLoad() {
        super.viewDidLoad()
        setUpInitialUI()
    }
    
    // MARK: - Initial UI Setup methods
    fileprivate func setUpInitialUI() {
        lblText.text = Greeting().greeting()
    }

}
